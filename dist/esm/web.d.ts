import { WebPlugin } from '@capacitor/core';
import { NativeHttpPlugin } from './definitions';
export declare class NativeHttpWeb extends WebPlugin implements NativeHttpPlugin {
    constructor();
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
}
declare const NativeHttp: NativeHttpWeb;
export { NativeHttp };
