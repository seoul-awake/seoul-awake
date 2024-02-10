import * as stylex from '@stylexjs/stylex';

interface ColorTokens {
  [key: string]: {
    [shade: string]: string;
  };
}

export const colorTokens = stylex.defineVars({
  primary: { default: '#F5B343' },
  grayScale: { default: '#9E9E9E' },
} as const satisfies ColorTokens);
