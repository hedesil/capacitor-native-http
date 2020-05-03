import { WebPlugin } from '@capacitor/core';
import {NativeHttpPlugin, SetResult} from './definitions';

export class NativeHttpWeb extends WebPlugin implements NativeHttpPlugin {
  constructor() {
    super({
      name: 'NativeHttp',
      platforms: ['web']
    });
  }

  async capacitorGetRequest(): Promise<any> {
    console.log('CAPACITOR GET')
    return Promise.resolve(undefined);
  }

  async disable(): Promise<SetResult> {
    return Promise.resolve({ isEnabled: undefined });
  }

  async enable(): Promise<SetResult> {
    return Promise.resolve({ isEnabled: undefined });
  }
}

const NativeHttp = new NativeHttpWeb();

export { NativeHttp };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(NativeHttp);
