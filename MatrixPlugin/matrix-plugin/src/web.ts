import { WebPlugin } from '@capacitor/core';
import { MatrixPluginPlugin } from './definitions';

export class MatrixPluginWeb extends WebPlugin implements MatrixPluginPlugin {
  constructor() {
    super({
      name: 'MatrixPlugin',
      platforms: ['web'],
    });
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  async Mult(options: { a: Array<number>, b: Array<number> }): Promise<{ value: Array<number> }> {
    console.log(options.a);
    console.log(options.b);
    let res = new Array(options.a.length);
    for (let i = 0; i < options.a.length; i++)
      res[i] = options.a[i] + options.b[i];


    return { value: res };
  }

}

const MatrixPlugin = new MatrixPluginWeb();

export { MatrixPlugin };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(MatrixPlugin);
