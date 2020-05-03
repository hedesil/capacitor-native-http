declare module "@capacitor/core" {
  interface PluginRegistry {
    NativeHttp: NativeHttpPlugin;
  }
}

export interface NativeHttpPlugin {
  echo(options: { value: string }): Promise<{value: string}>;
}
