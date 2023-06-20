import { style } from "@vanilla-extract/css";

export interface ButtonProps
  extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  size?: "medium" | "small";
  variant?: "primary" | "secondary";
  fullWidth?: boolean;
  disabled?: boolean;
}

export const ButtonStyle = style({
  border: "none",
  borderRadius: "8px",
  padding: "16px 20px",
  fontSize: "16px",
  cursor: "pointer",
});
