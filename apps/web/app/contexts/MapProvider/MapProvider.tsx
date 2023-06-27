"use client";

/* eslint-disable react-hooks/exhaustive-deps */
import type { KakaoMapProps } from "@seoul-awake/types";
import { useEffect, useRef, useState, type PropsWithChildren } from "react";
import { Context, useKakaoDebounce } from "./MapProvider.hooks";

type MapProviderProps = KakaoMapProps & {
  debounceDelay?: number;
};

const DEFAULT_DEBOUNCE_DELAY = 200;

export const MapProvider = ({
  center,
  level,
  draggable,
  zoomable,
  maxLevel,
  minLevel,
  onLoaded,
  onBoundChange,
  debounceDelay = DEFAULT_DEBOUNCE_DELAY,
  children,
}: PropsWithChildren<MapProviderProps>) => {
  const [map, setMap] = useState<kakao.maps.Map | null>(null);
  const mapRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    if (!mapRef.current) return;

    kakao.maps.load(() => {
      const newMap = new kakao.maps.Map(mapRef.current, {
        draggable,
        center: new kakao.maps.LatLng(center.latitude, center.longitude),
        level,
      });

      if (maxLevel) {
        newMap.setMaxLevel(maxLevel);
      }

      setMap(newMap);
      onLoaded?.(newMap);
    });
  }, []);

  useEffect(() => {
    if (!map) return;

    map.setZoomable(zoomable);
    map.setDraggable(draggable);
    map.setLevel(level);

    if (!zoomable) {
      map.setMaxLevel(level);
      map.setMinLevel(level);
    } else {
      map.setMaxLevel(maxLevel);
      map.setMinLevel(minLevel);
    }

    if (center) {
      map.panTo(new kakao.maps.LatLng(center.latitude, center.longitude));
    }

    map.relayout();
  }, [map, zoomable, draggable, level, maxLevel, minLevel, center]);

  const bounds = map?.getBounds();
  const northEast = bounds?.getNorthEast();
  const southWest = bounds?.getSouthWest();

  const debouncedNorthEastLat = useKakaoDebounce(
    northEast?.getLat(),
    debounceDelay
  );
  const debouncedNorthEastLng = useKakaoDebounce(
    northEast?.getLng(),
    debounceDelay
  );
  const debouncedSouthWestLat = useKakaoDebounce(
    southWest?.getLat(),
    debounceDelay
  );
  const debouncedSouthWestLng = useKakaoDebounce(
    southWest?.getLng(),
    debounceDelay
  );

  useEffect(() => {
    if (
      map &&
      debouncedNorthEastLat &&
      debouncedNorthEastLng &&
      debouncedSouthWestLat &&
      debouncedSouthWestLng
    ) {
      requestAnimationFrame(() => {
        onBoundChange?.(map);
      });
    }
  }, [
    debouncedNorthEastLat,
    debouncedNorthEastLng,
    debouncedSouthWestLat,
    debouncedSouthWestLng,
  ]);

  return (
    <Context.Provider value={{ map, mapRef }}>{children}</Context.Provider>
  );
};
