const { Position, Range } = require('vscode');
const BracketPair = require('./bracketPair');
const ColorMode = require('./colorMode');
const ColorIndexes = require('./colorIndexes'); 
const ModifierPair = require('./modifierPair');
const MultipleIndexes = require('./multipleIndexes'); 
const Scope = require('./scope');
const Settings = require('./settings'); 
const SingularIndex = require('./singularIndex'); 

const LineState = require('./lineState'); 

describe('LineState', () => {
  const settings = new Settings({
    colorMode: ColorMode.Consecutive,
    forceIterationColorCycle: false,
    forceUniqueOpeningColor: true,
  });
  const bracketPair = new BracketPair({
    colors: ['red', 'blue', 'green'],
    orphanColor: 'gray',
  });
  const range = new Range();

  it('retorna a cor correta para um caractere de abertura', () => {
    const lineState = new LineState(settings);

    const caractereAberto = lineState.getOpenBracketColor(bracketPair, range);

    expect(caractereAberto).toBeDefined();
    expect(typeof caractereAberto).toBe('string'); 
    expect(bracketPair.colors).toContain(caractereAberto);
  });

  it('retorna a cor correta para um caractere de encerramento', () => {
    const lineState = new LineState(settings);

    const caractereFechado = lineState.getCloseBracketColor(bracketPair, range);

    expect(caractereFechado).toBeDefined();
    expect(typeof caractereFechado).toBe('string'); 
    expect(bracketPair.colors).toContain(caractereFechado);

  it('retorna os caracteres abertos corretamente', () => {
    const lineState = new LineState(settings);

    const caractereAberto = lineState.getOpenBrackets();

    expect(caractereAberto).toBeDefined(); 
    expect(Array.isArray(caractereAberto)).toBe(true); 
    
  });



});
