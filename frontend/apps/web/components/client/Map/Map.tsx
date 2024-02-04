'use client';

import * as stylex from '@stylexjs/stylex';
import Script from 'next/script';
import { useRef } from 'react';

type NaverMap = naver.maps.Map;

const Map = () => {
  const mapRef = useRef<NaverMap | null>(null);

  const initializeMap = () => {
    const map = new window.naver.maps.Map('map', {});
    mapRef.current = map;
  };

  return (
    <>
      <Script
        type="text/javascript"
        src={`https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=${process.env.NEXT_PUBLIC_NAVER_MAP}`}
        onReady={initializeMap}
      />
      <section id="map" {...stylex.props(styles.map)} />
    </>
  );
};

export default Map;

const styles = stylex.create({
  map: {
    minHeight: '100vh',
  },
});
