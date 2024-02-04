import './globals.css';

import * as stylex from '@stylexjs/stylex';
import type { Metadata } from 'next';
import Image from 'next/image';

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
      <body {...stylex.props(styles.body)}>
        <aside {...stylex.props(styles['side-section'])}>
          <h1 {...stylex.props(styles.title)}>
            <Image
              width={100}
              height={100}
              alt="logo"
              src="/logo.webp"
              priority={true}
              {...stylex.props(styles.logo)}
            />
            SEOUL AWAKE
          </h1>
        </aside>
        <main {...stylex.props(styles.main)}>{children}</main>
      </body>
    </html>
  );
}

const DARK = '@media (prefers-color-scheme: dark)';
const MEDIA_MOBILE = '@media (max-width: 700px)' as const;
const MEDIA_TABLET =
  '@media (min-width: 701px) and (max-width: 1120px)' as const;

const styles = stylex.create({
  html: {
    height: '100%',
    colorScheme: 'light dark',
  },
  body: {
    display: 'flex',
    backgroundImage: {
      default: 'linear-gradient(to bottom, rgb(214, 219, 220), white)',
      [DARK]: 'linear-gradient(to bottom, #161B1C, #393c3d)',
    },
  },
  logo: {
    borderRadius: '16px',
  },
  'side-section': {
    display: { default: 'flex', [MEDIA_MOBILE]: 'none' },
    flex: '1',
    alignItems: 'center',
    justifyContent: 'center',
  },
  title: {
    display: 'flex',
    fontSize: { [MEDIA_TABLET]: '1rem' },
    flexDirection: 'column',
    gap: '1rem',
    alignItems: 'center',
    fontWeight: 400,
  },
  main: {
    height: 'fit-content',
    minHeight: '100dvh',
    flex: '4',
  },
});
