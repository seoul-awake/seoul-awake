import * as stylex from '@stylexjs/stylex';
import React from 'react';

const Spinner = () => {
  return (
    <figure
      {...stylex.props(styles.spinner)}
      role="status"
      aria-label="Loading"
    >
      <div {...stylex.props(styles.centerCircle)} />
      {[0, 1, 2, 3].map((index) => (
        <div {...stylex.props(styles.circle(index))} key={index} />
      ))}
    </figure>
  );
};

export default Spinner;

const rotateAnimation = stylex.keyframes({
  '0%': {
    transform: 'rotate(0deg) translateX(20px) rotate(0deg)',
  },
  '50%': {
    transform: 'rotate(180deg) translateX(20px) rotate(-180deg)',
  },
  '100%': {
    transform: 'rotate(360deg) translateX(20px) rotate(-360deg)',
  },
});

const styles = stylex.create({
  spinner: {
    display: 'inline-flex',
    alignItems: 'center',
    justifyContent: 'center',
    position: 'relative',
    width: '50px',
    height: '50px',
  },
  circle: (delay: number) => ({
    position: 'absolute',
    width: '8px',
    height: '8px',
    backgroundColor: '#F5B343',
    borderRadius: '50%',
    animationName: rotateAnimation,
    animationDuration: '5s',
    animationTimingFunction: 'linear',
    animationIterationCount: 'infinite',
    animationFillMode: 'forwards',
    animationDelay: `${-1.5 * delay}s`,
  }),
  centerCircle: {
    width: '16px',
    height: '16px',
    backgroundColor: '#F5B343',
    borderRadius: '50%',
  },
});
