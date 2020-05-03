import { WebPlugin } from '@capacitor/core';
import { NativeHttpPlugin } from './definitions';

export class NativeHttpWeb extends WebPlugin implements NativeHttpPlugin {
  constructor() {
    super({
      name: 'NativeHttp',
      platforms: ['web']
    });
  }

  async echo(options: { value: string }): Promise<{value: string}> {
    console.log('ECHO', options);
    return options;
  }
}

const NativeHttp = new NativeHttpWeb();

export { NativeHttp };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(NativeHttp);
