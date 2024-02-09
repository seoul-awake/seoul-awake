import { useEffect, useState } from 'react';

interface UseModalClosingParams {
  opened: boolean;
  closingDuration?: number;
}

type ModalClosingState = 'CLOSED' | 'CLOSING' | 'OPENED';

export const useModal = ({
  opened,
  closingDuration,
}: UseModalClosingParams) => {
  const [state, setState] = useState<ModalClosingState>(
    opened ? 'OPENED' : 'CLOSED',
  );

  useEffect(() => {
    if (opened) setState('OPENED');
    else {
      setState((prev) => {
        if (prev === 'OPENED') return 'CLOSING';

        return prev;
      });
    }
  }, [opened]);

  useEffect(() => {
    if (state === 'CLOSING') {
      const closeTimer = setTimeout(() => setState('CLOSED'), closingDuration);

      return () => clearTimeout(closeTimer);
    }
  }, [state, closingDuration]);

  return state;
};
