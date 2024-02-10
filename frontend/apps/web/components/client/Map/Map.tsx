'use client';

import { useMapStore } from '@/stores';
import * as stylex from '@stylexjs/stylex';
import Script from 'next/script';

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
        onLoad={initializeMap}
      />
      <div id="map" {...stylex.props(styles.map)} />
    </>
  );
};

export default Map;

const styles = stylex.create({
  map: {
    minHeight: '100vh',
  },
});
