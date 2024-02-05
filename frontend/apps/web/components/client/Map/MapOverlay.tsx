'use client';

import React, {
  forwardRef,
  useEffect,
  useImperativeHandle,
  useMemo,
  useRef,
} from 'react';
import { createPortal } from 'react-dom';
import { useMapStore } from '../../../stores/MapStore';

type Props = {
  position: { lat: number; lng: number };
  children: React.ReactNode;
};

//TODO 간헐적으로 렌더링이 안 되는 이슈 (2024.02.05)
const MapOverlay = forwardRef<naver.maps.OverlayView, Props>(
  ({ position, children }, ref) => {
    const mapRef = useMapStore((state) => state.mapRef);
    const container = useRef<HTMLDivElement | null>(null);

    const overlay = useMemo(() => {
      if (!container.current) return;

      const customOverlay = new window.naver.maps.OverlayView();
      customOverlay.onAdd = function () {
        const overlayLayer = this.getPanes().overlayLayer;
        if (!container.current) return;
        overlayLayer.appendChild(container.current);
      };
      customOverlay.draw = function () {
        const projection = this.getProjection();
        const positionLatLng = new window.naver.maps.LatLng(
          position.lat,
          position.lng,
        );
        const pixelPosition = projection.fromCoordToOffset(positionLatLng);

        if (container.current) {
          container.current.style.position = 'absolute';
          container.current.style.left = `${pixelPosition.x}px`;
          container.current.style.top = `${pixelPosition.y}px`;
        }
      };
      customOverlay.onRemove = function () {
        if (container.current && container.current.parentNode) {
          container.current.parentNode.removeChild(container.current);
        }
      };

      return customOverlay;
    }, [position]);

    useImperativeHandle(ref, () => overlay!, [overlay]);

    useEffect(() => {
      if (mapRef.current && overlay) overlay.setMap(mapRef.current);
      return () => {
        if (overlay) overlay.setMap(null);
      };
    }, [mapRef, overlay]);

    if (!container.current) return null;
    return createPortal(children, container.current);
  },
);

export default MapOverlay;
