const { build } = require("esbuild");
const { vanillaExtractPlugin } = require("@vanilla-extract/esbuild-plugin");

build({
  format: "esm",
  target: "es2015",
  entryPoints: ["./src/index.ts"],
  bundle: true,
  plugins: [vanillaExtractPlugin()],
  outdir: "dist",
}).catch(() => process.exit(1));
