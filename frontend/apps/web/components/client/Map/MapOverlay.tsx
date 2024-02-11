'use client';

import { useMapStore } from '@/stores';
import React, { useEffect, useRef } from 'react';
import { createPortal } from 'react-dom';

interface MapOverlayProps {
  position: { lat: number; lng: number };
  children: React.ReactNode;
}

const MapOverlay = ({ position, children }: MapOverlayProps) => {
  const map = useMapStore((state) => state.map);
  const containerRef = useRef<HTMLDivElement>(document.createElement('div'));

  useEffect(() => {
    if (!map) return;

    const customOverlay = new naver.maps.OverlayView();

    customOverlay.onAdd = function () {
      const overlayLayer = this.getPanes().overlayLayer;
      overlayLayer.appendChild(containerRef.current);
    };

    customOverlay.draw = function () {
      const projection = this.getProjection();
      const pixelPosition = projection.fromCoordToOffset(
        new naver.maps.LatLng(position.lat, position.lng),
      );

      if (containerRef.current) {
        containerRef.current.style.position = 'absolute';
        containerRef.current.style.left = `${pixelPosition.x}px`;
        containerRef.current.style.top = `${pixelPosition.y}px`;
      }
    };

    customOverlay.onRemove = function () {
      if (containerRef.current.parentNode) {
        containerRef.current.parentNode.removeChild(containerRef.current);
      }
    };

    customOverlay.setMap(map);

    return () => {
      customOverlay.setMap(null);
    };
  }, [map, position]);

  return createPortal(children, containerRef.current);
};

export default MapOverlay;
