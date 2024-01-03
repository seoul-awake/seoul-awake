/** @type {import("eslint").Linter.Config} */
module.exports = {
  root: true,
  extends: ['@seoul-awake/eslint-config/next.js'],
  parser: '@typescript-eslint/parser',
  plugins: ['@stylexjs'],
  parserOptions: {
    project: true,
  },
  rules: {
    '@stylexjs/valid-styles': 'error',
    'no-unused-vars': 'off',
  },
};
