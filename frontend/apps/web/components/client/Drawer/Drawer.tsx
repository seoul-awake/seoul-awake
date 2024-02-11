'use client';

import { MODAL, useModal } from '@/hooks';
import * as stylex from '@stylexjs/stylex';
import { HTMLAttributes } from 'react';
import { createPortal } from 'react-dom';

interface DrawerProps extends HTMLAttributes<HTMLElement> {
  opened?: boolean;
  onClose?: () => void;
  backgroundScroll?: boolean;
}

const Drawer = ({
  opened = true,
  backgroundScroll = false,
  onClose,
  children,
  ...restAsideProps
}: DrawerProps) => {
  const openingTransition = useModal({
    opened,
    closingDuration: 200,
  });

  return openingTransition
    ? createPortal(
        <div
          {...stylex.props(
            styles.modalContainer,
            openingTransition !== MODAL.CLOSING
              ? styles.modalContainerFadeIn
              : styles.modalContainerFadeOut,
          )}
        >
          <div {...stylex.props(styles.backgroundLayer)} onClick={onClose} />
          <aside
            {...stylex.props(
              styles.modalWrap,
              openingTransition !== MODAL.CLOSING
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

export default Drawer;

const DARK = '@media (prefers-color-scheme: dark)';

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
    height: '100%',
    maxHeight: '100%',
    overflowY: 'auto',
    boxShadow: '0 4px 6px rgba(0, 0, 0, 0.1)',
    width: '200px',
    alignItems: 'center',
    justifyContent: 'center',
    borderRadius: '0 6px 6px 0',
    backgroundColor: {
      default: 'white',
      [DARK]: '#171717',
    },
    color: {
      default: '#171717',
      [DARK]: 'white',
    },
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
    animationName: slideInLeft,
    animationDuration: '0.2s',
    animationFillMode: 'forwards',
  },
  modalWrapSlideOut: {
    animationName: slideOutLeft,
    animationDuration: '0.2s',
    animationFillMode: 'forwards',
  },
});
