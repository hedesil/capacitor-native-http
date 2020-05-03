declare module "@capacitor/core" {
  interface PluginRegistry {
    NativeHttp: NativeHttpPlugin;
  }
}

export interface NativeHttpPlugin {
  capacitorGetRequest(): Promise<any>;
  enable(): Promise<SetResult>
  disable(): Promise<SetResult>;
}

export class State{
  constructor(public isEnabled: boolean) {
  }
}

export type SetResult = State