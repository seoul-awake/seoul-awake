import { animations } from '@/styles/animations.stylex';
import { colorTokens } from '@/styles/colorTokens.stylex';
import stylex from '@stylexjs/stylex';
import React from 'react';

interface SpinnerProps {
  size?: 'medium' | 'large';
}

const Spinner = ({ size = 'medium' }: SpinnerProps) => {
  return (
    <figure
      {...stylex.props(styles.spinner(size))}
      role="status"
      aria-label="Loading"
    >
      <div {...stylex.props(styles.centerCircle(size))} />
      {[0, 1, 2, 3].map((index) => (
        <div {...stylex.props(styles.circle(size, index))} key={index} />
      ))}
    </figure>
  );
};

export default Spinner;

const styles = stylex.create({
  spinner: (size: 'medium' | 'large') => ({
    display: 'inline-flex',
    alignItems: 'center',
    justifyContent: 'center',
    position: 'relative',
    width: `${sizeMap[size].spinner}px`,
    height: `${sizeMap[size].spinner}px`,
  }),
  circle: (size: 'medium' | 'large', delay: number) => ({
    position: 'absolute',
    width: `${sizeMap[size].circle}px`,
    height: `${sizeMap[size].circle}px`,
    backgroundColor: colorTokens.primary,
    borderRadius: '50%',
    animationName: animations.rotateAnimation,
    animationDuration: '5s',
    animationTimingFunction: 'linear',
    animationIterationCount: 'infinite',
    animationFillMode: 'forwards',
    animationDelay: `${-1.5 * delay}s`,
  }),
  centerCircle: (size: 'medium' | 'large') => ({
    width: `${sizeMap[size].centerCircle}px`,
    height: `${sizeMap[size].centerCircle}px`,
    backgroundColor: colorTokens.primary,
    borderRadius: '50%',
  }),
});

const sizeMap = {
  medium: { spinner: 50, circle: 8, centerCircle: 16 },
  large: { spinner: 70, circle: 10, centerCircle: 20 },
};
