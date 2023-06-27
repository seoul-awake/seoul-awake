import "kakao.maps.d.ts";

import { CSSProperties } from "react";
import { Coordinate } from "./common";

export interface KakaoMapProps {
  center?: Coordinate;
  level?: number;
  minLevel?: number;
  maxLevel?: number;
  draggable?: boolean;
  zoomable?: boolean;
  onClick?: (map: kakao.maps.Map, e: kakao.maps.event.MouseEvent) => void;
  onDragStart?: (map: kakao.maps.Map, e: kakao.maps.event.MouseEvent) => void;
  onDragEnd?: (map: kakao.maps.Map, e: kakao.maps.event.MouseEvent) => void;
  onZoomChanged?: (map: kakao.maps.Map) => void;
  onTilesloaded?: (map: kakao.maps.Map) => void;
  onLoaded?: (map: kakao.maps.Map) => void;
  onBoundChange?: (map: kakao.maps.Map) => void;
  style?: CSSProperties;
}
