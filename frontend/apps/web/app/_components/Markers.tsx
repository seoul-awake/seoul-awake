'use client';

import { MapOverlay } from '@/components/client';
import { animations } from '@/styles/index.stylex';
import * as stylex from '@stylexjs/stylex';

const locations = [
  { lat: 37.526072, lng: 126.864301 }, // Mok-dong station
  { lat: 37.6438741, lng: 126.6690268 }, // Janggi station
];

const Markers = () => {
  return locations.map((position) => (
    <MapOverlay key={position.lat} position={position}>
      <div {...stylex.props(styles.icon)}>tooooo1</div>
    </MapOverlay>
  ));
};

export default Markers;

const styles = stylex.create({
  icon: {
    backgroundColor: 'white',
    padding: '10px',
    borderRadius: '8px',
    animationName: animations.fadeInAndScale,
    animationDuration: '0.3s',
    animationTimingFunction: 'linear',
    animationFillMode: 'forwards',
    scale: {
      default: 1,
      ':hover': 1.05,
      ':active': 0.95,
    },
    transition: 'scale 0.3s ease',
    cursor: 'pointer',
    userSelect: 'none',
  },
});
