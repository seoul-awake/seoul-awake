'use client';

import * as stylex from '@stylexjs/stylex';
import Script from 'next/script';
import { useMapStore } from '../../../stores/MapStore';

const Map = () => {
  const setMap = useMapStore((state) => state.setMap);

  const initializeMap = () => {
    const mapOptions = {
      zoom: 12,
      minZoom: 11,
      scaleControl: false,
      mapDataControl: false,
    };

    const map = new window.naver.maps.Map('map', mapOptions);
    setMap(map);
  };

  return (
    <>
      <Script
        type="text/javascript"
        src={`https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=${process.env.NEXT_PUBLIC_NAVER_MAP}`}
        onReady={initializeMap}
      />
      <div id="map" {...stylex.props(styles.map)} />
    </>
  );
};

export default Map;

const scale = stylex.keyframes({
  from: { transform: 'scales(0)' },
  to: { transform: 'scales(1)' },
});

const styles = stylex.create({
  map: {
    minHeight: '100vh',
  },
  icon: {
    animationName: scale,
    animationDuration: '2s',
    animationIterationCount: 'infinite',
    animationTimingFunction: 'linear',
  },
});
