import {
  createContext,
  useContext,
  useEffect,
  useState,
  type RefObject,
} from "react";

type KakaoMapContextType = {
  map: kakao.maps.Map | null;
  mapRef: RefObject<HTMLDivElement>;
};

const DEFAULT_CONTEXT_VALUE: KakaoMapContextType = {
  map: null,
  mapRef: { current: null },
};

export const Context = createContext<KakaoMapContextType>(
  DEFAULT_CONTEXT_VALUE
);

const DEFAULT_DEBOUNCE_DELAY = 500;

export const useKakaoMap = () => useContext(Context);

export const useKakaoDebounce = <T>(
  value: T,
  delay: number = DEFAULT_DEBOUNCE_DELAY
): T => {
  const [debouncedValue, setDebouncedValue] = useState<T>(value);

  useEffect(() => {
    const timer = setTimeout(() => setDebouncedValue(value), delay);

    return () => {
      clearTimeout(timer);
    };
  }, [value, delay]);

  return debouncedValue;
};
