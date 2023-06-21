
import name2rgb  from '../src/colors';

describe('testing return hex color', () => {
  test('return name hex color azure', () => {
    expect(name2rgb('azure')).toBe("#f0ffff");
  });

});