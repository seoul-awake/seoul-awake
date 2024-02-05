import { MutableRefObject } from 'react';
import { create } from 'zustand';

type MapType = naver.maps.Map | null;

interface MapState {
  mapRef: MutableRefObject<MapType>;
  setMap: (map: MapType) => void;
}

export const useMapStore = create<MapState>((set) => ({
  mapRef: { current: null },
  setMap: (map: MapType) =>
    set((state) => {
      state.mapRef.current = map;
      return { mapRef: state.mapRef };
    }),
}));
