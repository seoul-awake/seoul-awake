import './globals.css';

import * as stylex from '@stylexjs/stylex';
import type { Metadata } from 'next';
import Aside from './_components/Aside';

export const metadata = {
  title: 'Seoul Awake',
  description: '24-hour cafes in Seoul, the city that never sleeps',
} satisfies Metadata;

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html {...stylex.props(styles.html)} lang="ko">
      <body>
        <Aside />
        <main>{children}</main>
      </body>
    </html>
  );
}

const DARK = '@media (prefers-color-scheme: dark)';

const styles = stylex.create({
  html: {
    height: '100%',
    colorScheme: 'light dark',
  },
});
