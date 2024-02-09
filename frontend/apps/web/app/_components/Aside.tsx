'use client';

import { Drawer } from '@/components/client';
import * as stylex from '@stylexjs/stylex';
import Image from 'next/image';
import { useState } from 'react';

const Aside = () => {
  const [isDrawerOpened, setIsDrawerOpened] = useState(false);

  return (
    <>
      <button
        {...stylex.props(styles.menu)}
        type="button"
        onClick={() => setIsDrawerOpened((prev) => !prev)}
      >
        <Image
          {...stylex.props(styles.logo)}
          width={50}
          height={50}
          alt="logo"
          src="/logo.webp"
          priority
        />
      </button>
      <Drawer opened={isDrawerOpened} onClose={() => setIsDrawerOpened(false)}>
        tooooo1
      </Drawer>
    </>
  );
};

export default Aside;

const styles = stylex.create({
  menu: {
    borderStyle: 'none',
    backgroundColor: 'transparent',
    position: 'fixed',
    top: '20px',
    left: '20px',
    zIndex: 102,
    cursor: 'pointer',
    borderRadius: '16px',
    display: 'flex',
    scale: {
      default: 1,
      ':hover': 1.05,
      ':active': 0.95,
    },
    transition: 'scale 0.3s ease',
  },
  logo: {
    borderRadius: '16px',
  },
});
