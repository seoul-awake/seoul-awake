module.exports = {
  root: true,
  // This tells ESLint to load the config from the package `eslint-config-seoul-awake`
  extends: ["seoul-awake"],
  settings: {
    next: {
      rootDir: ["apps/*/"],
    },
  },
};
