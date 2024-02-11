import * as stylex from '@stylexjs/stylex';

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

const fadeIn = stylex.keyframes({
  from: { opacity: 0 },
  to: { opacity: 1 },
});

const slideInLeft = stylex.keyframes({
  from: { transform: 'translateX(0)' },
  to: { transform: 'translateX(-100%)' },
});

const fadeOut = stylex.keyframes({
  from: { opacity: 1 },
  to: { opacity: 0 },
});

const slideOutLeft = stylex.keyframes({
  from: { transform: 'translateX(-100%)' },
  to: { transform: 'translateX(0)' },
});

const fadeInAndScale = stylex.keyframes({
  '0%': { opacity: 0, transform: 'scale(0)' },
  '100%': { opacity: 1, transform: 'scale(1)' },
});

export const animations = stylex.defineVars({
  rotateAnimation,
  fadeIn,
  fadeOut,
  slideInLeft,
  slideOutLeft,
  fadeInAndScale,
});
