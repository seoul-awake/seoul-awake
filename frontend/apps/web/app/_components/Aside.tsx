'use client';

import * as stylex from '@stylexjs/stylex';
import { useState } from 'react';
import { Drawer } from '../../components/client/Drawer/Drawer';
import Image from 'next/image';

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
    zIndex: 101,
    cursor: 'pointer',
  },
  logo: {
    borderRadius: '16px',
  },
});
