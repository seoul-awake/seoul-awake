import stylex from '@stylexjs/stylex';

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
    backgroundColor: '#F5B343',
    borderRadius: '50%',
    animationName: rotateAnimation,
    animationDuration: '5s',
    animationTimingFunction: 'linear',
    animationIterationCount: 'infinite',
    animationFillMode: 'forwards',
    animationDelay: `${-1.5 * delay}s`,
  }),
  centerCircle: (size: 'medium' | 'large') => ({
    width: `${sizeMap[size].centerCircle}px`,
    height: `${sizeMap[size].centerCircle}px`,
    backgroundColor: '#F5B343',
    borderRadius: '50%',
  }),
});

const sizeMap = {
  medium: { spinner: 50, circle: 8, centerCircle: 16 },
  large: { spinner: 70, circle: 10, centerCircle: 20 },
};
