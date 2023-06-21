import { forwardRef, PropsWithChildren } from "react";
import { ButtonStyle, type ButtonProps } from "./Button.css";

export const Button = forwardRef<
  HTMLButtonElement,
  PropsWithChildren<ButtonProps>
>(
  (
    {
      size = "small",
      variant = "primary",
      fullWidth = false,
      disabled = false,
      children,
      ...props
    },
    ref
  ) => {
    return (
      <button
        disabled={disabled}
        ref={ref}
        className={`${ButtonStyle}`}
        {...props}
      >
        {children}
      </button>
    );
  }
);
