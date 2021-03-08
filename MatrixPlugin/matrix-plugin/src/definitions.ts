declare module '@capacitor/core' {
  interface PluginRegistry {
    MatrixPlugin: MatrixPluginPlugin;
  }
}

export interface MatrixPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  Mult(options:{a: Array<number>, b: Array<number>}): Promise<{ value: Array<number> }>;
}
