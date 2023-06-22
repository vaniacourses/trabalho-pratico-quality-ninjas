import LineState from '../src/lineState';
import TextLine from '../src/textLine';

jest.mock('../src/settings');

describe('TextLine', () => {
  let textLine: TextLine;
  let lineState: LineState;
  const content = 'Linha de teste.';
  const index = 0;

  describe('copyMultilineContext', () => {
    it('Deve retornar uma cópia da linha com o estado do bracket preservado', () => {
      const lineStateCopy = textLine.copyMultilineContext();

      expect(lineStateCopy).toBeInstanceOf(LineState);
      expect(lineStateCopy).not.toBe(lineState);
      expect(lineStateCopy.getOpenBrackets()).toEqual(lineState.getOpenBrackets());      
    });
  });
});

function expect(value: any): jest.Matchers<any> {
    return new jest.Matchers(value);
  }
