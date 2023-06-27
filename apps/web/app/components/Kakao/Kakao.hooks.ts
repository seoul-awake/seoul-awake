"use client";

import { useCallback, useEffect } from "react";
import { useKakaoMap } from "../../contexts";

/**
 * Kakao Map의 이벤트에 대한 콜백 핸들러를 등록하고, 컴포넌트가 unmount될 때 핸들러를 제거하는 custom hook.
 *
 * @param target - 이벤트 대상 (예: 마커, 맵 등)
 * @param type - 이벤트 타입 (예: "click", "dragend" 등)
 * @param callback - 이벤트 발생 시 호출될 콜백 함수
 */
const useMapEvent = (
  target: kakao.maps.event.EventTarget | null,
  type: string,
  callback?: (map: kakao.maps.Map, event: kakao.maps.event.MouseEvent) => void
) => {
  const { map } = useKakaoMap();

  const eventHandler = useCallback(
    (event: kakao.maps.event.MouseEvent) => {
      if (map) {
        callback?.(map, event);
      }
    },
    [callback, map]
  );

  useEffect(() => {
    if (!target) return;

    kakao.maps.event.addListener(target, type, eventHandler);

    return () => kakao.maps.event.removeListener(target, type, eventHandler);
  }, [eventHandler, target, type]);
};

export default useMapEvent;
