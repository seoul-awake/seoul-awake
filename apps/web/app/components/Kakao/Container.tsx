import type { KakaoMapProps } from "@seoul-awake/types";
import type { PropsWithChildren } from "react";
import { useKakaoMap } from "../../contexts";
import useMapEvent from "./Kakao.hooks";

const Container = ({
  onClick,
  onDragStart,
  onDragEnd,
  onZoomChanged,
  onTilesloaded,
  style,
  children,
}: PropsWithChildren<KakaoMapProps>) => {
  const { map, mapRef } = useKakaoMap();

  useMapEvent(map, "click", onClick);
  useMapEvent(map, "dragstart", onDragStart);
  useMapEvent(map, "dragend", onDragEnd);
  useMapEvent(map, "zoom_changed", onZoomChanged);
  useMapEvent(map, "tilesloaded", onTilesloaded);

  const containerStyle = {
    zIndex: 0,
    ...style,
  };

  return (
    <div ref={mapRef} style={containerStyle}>
      {map ? children : null}
    </div>
  );
};

export default Container;
