import { create } from 'zustand';

type MapType = naver.maps.Map | null;

interface MapState {
  map: MapType;
  setMap: (map: MapType) => void;
}

export const useMapStore = create<MapState>((set) => ({
  map: null,
  setMap: (map: MapType) => set(() => ({ map })),
}));
