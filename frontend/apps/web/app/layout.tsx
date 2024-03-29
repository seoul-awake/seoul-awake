import '@/styles/globals.css';

import * as stylex from '@stylexjs/stylex';
import type { Metadata } from 'next';

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
        <main>{children}</main>
      </body>
    </html>
  );
}

const styles = stylex.create({
  html: {
    height: '100%',
    colorScheme: 'light dark',
  },
});
