import GutterIconManager from './gutterIconManager';
import expect from 'expect';


describe("GutterIconManager", () => {
    it("deve descartar todos os callbacks", () => {
      const gutterIconManager = new GutterIconManager();
  
      // Simula a adição de callbacks no array de disposes
      gutterIconManager["disposables"].push(() => {
        console.log("Callback 1 descartado");
      });
      gutterIconManager["disposables"].push(() => {
        console.log("Callback 2 descartado");
      });
  
      // chama o metodo dispose
      gutterIconManager.Dispose();
  
      // Verifica se todos os callbacks foram chamados e descartados
      expect(gutterIconManager["disposables"]).toHaveLength(0);
    });
  });