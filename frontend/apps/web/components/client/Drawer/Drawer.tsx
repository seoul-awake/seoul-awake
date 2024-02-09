'use client';

import * as stylex from '@stylexjs/stylex';
import { HTMLAttributes, useEffect, useState } from 'react';
import { createPortal } from 'react-dom';
import { useModal } from '../../../hooks/useModal';

interface DrawerProps extends HTMLAttributes<HTMLElement> {
  opened?: boolean;
  onClose?: () => void;
  backgroundScroll?: boolean;
}

export const Drawer = ({
  opened = true,
  backgroundScroll = false,
  onClose,
  children,
  ...restAsideProps
}: DrawerProps) => {
  const [isClient, setIsClient] = useState(false);
  const openingTransition = useModal({
    opened,
    closingDuration: 200,
  });

  useEffect(() => {
    setIsClient(true);
  }, [opened]);

  return isClient && openingTransition
    ? createPortal(
        <div
          {...stylex.props(
            styles.modalContainer,
            openingTransition !== 'CLOSED'
              ? styles.modalContainerFadeIn
              : styles.modalContainerFadeOut,
          )}
        >
          <div {...stylex.props(styles.backgroundLayer)} onClick={onClose} />
          <aside
            {...stylex.props(
              styles.modalWrap,
              openingTransition !== 'CLOSED'
                ? styles.modalWrapSlideOut
                : styles.modalWrapSlideIn,
            )}
            {...restAsideProps}
          >
            {children}
          </aside>
        </div>,
        document.body,
      )
    : null;
};

const fadeIn = stylex.keyframes({
  from: { opacity: 0 },
  to: { opacity: 1 },
});

const slideInBottom = stylex.keyframes({
  from: { transform: 'translateY(100%)' },
  to: { transform: 'translateY(0)' },
});

const fadeOut = stylex.keyframes({
  from: { opacity: 1 },
  to: { opacity: 0 },
});

const slideOutBottom = stylex.keyframes({
  from: { transform: 'translateY(0)' },
  to: { transform: 'translateY(100%)' },
});

const styles = stylex.create({
  modalContainer: {
    position: 'fixed',
    top: 0,
    left: 0,
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'flex-start',
    width: '100%',
    height: '100%',
    zIndex: 101,
  },
  backgroundLayer: {
    position: 'absolute',
    top: 0,
    left: 0,
    width: '100%',
    height: '100%',
    backgroundColor: 'rgba(0, 0, 0, 0.5)',
    backdropFilter: 'blur(1px)',
  },
  modalWrap: {
    display: 'flex',
    flexDirection: 'column',
    maxHeight: '100%',
    overflowY: 'auto',
    backgroundColor: 'white',
    boxShadow: '0 4px 6px rgba(0, 0, 0, 0.1)',
    width: '160px',
  },
  modalContainerFadeIn: {
    animationName: fadeIn,
    animationDuration: '0.2s',
    animationFillMode: 'forwards',
  },
  modalContainerFadeOut: {
    animationName: fadeOut,
    animationDuration: '0.2s',
    animationFillMode: 'forwards',
  },
  modalWrapSlideIn: {
    animationName: slideInBottom,
    animationDuration: '0.2s',
    animationFillMode: 'forwards',
  },
  modalWrapSlideOut: {
    animationName: slideOutBottom,
    animationDuration: '0.2s',
    animationFillMode: 'forwards',
  },
});
