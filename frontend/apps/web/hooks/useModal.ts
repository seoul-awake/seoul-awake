import { useEffect, useState } from 'react';

interface UseModalClosingParams {
  opened: boolean;
  closingDuration?: number;
}

export enum MODAL {
  CLOSED = 0,
  CLOSING = 1,
  OPENED = 2,
}

const useModal = ({ opened, closingDuration }: UseModalClosingParams) => {
  const [state, setState] = useState(opened ? MODAL.OPENED : MODAL.CLOSED);

  useEffect(() => {
    if (opened) setState(MODAL.OPENED);
    else {
      setState((prev) => {
        if (prev === MODAL.OPENED) return MODAL.CLOSING;

        return prev;
      });
    }
  }, [opened]);

  useEffect(() => {
    if (state === MODAL.CLOSING) {
      const closeTimer = setTimeout(
        () => setState(MODAL.CLOSED),
        closingDuration,
      );

      return () => clearTimeout(closeTimer);
    }
  }, [state, closingDuration]);

  return state;
};

export default useModal;
