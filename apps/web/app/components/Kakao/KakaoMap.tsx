import type { KakaoMapProps } from "@seoul-awake/types";
import type { PropsWithChildren } from "react";
import { MapProvider } from "../../contexts";
import Container from "./Container";

// 서울의 경도, 위도
export const DEFAULT_INITIAL_CENTER = { latitude: 37.5665, longitude: 126.978 };

const KakaoMap = ({
  center = DEFAULT_INITIAL_CENTER,
  level = 6,
  minLevel = 1,
  maxLevel = 8,
  draggable = true,
  zoomable = true,
  onClick,
  onDragStart,
  onDragEnd,
  onZoomChanged,
  onTilesloaded,
  style,
  onLoaded,
  onBoundChange,
  children,
}: PropsWithChildren<KakaoMapProps>) => {
  return (
    <MapProvider
      center={center}
      level={level}
      minLevel={minLevel}
      maxLevel={maxLevel}
      onLoaded={onLoaded}
      onBoundChange={onBoundChange}
      draggable={draggable}
      zoomable={zoomable}
    >
      <Container
        onClick={onClick}
        onDragStart={onDragStart}
        onDragEnd={onDragEnd}
        onZoomChanged={onZoomChanged}
        onTilesloaded={onTilesloaded}
        style={style}
      >
        {children}
      </Container>
    </MapProvider>
  );
};

export default KakaoMap;
