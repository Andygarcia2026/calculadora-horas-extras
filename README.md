# Calculadora de Horas Extras - CLT

Projeto Java para cálculo de horas extras seguindo a base de 220h mensais da CLT. Desenvolvido com foco em código limpo, métodos separados e experiência do usuário brasileiro.

### O que eu aprendi / apliquei aqui
- **Refatoração:** Código separado em métodos com responsabilidade única (Single Responsibility)
- **Tratamento de entrada:** Método `converterParaDouble()` que aceita qualquer formato brasileiro:
    - `3500` / `3.500` / `3.500,50` / `2500,50` -> tudo funciona
- **Organização:** Classe dedicada `CalculadoraHoraExtra` + `Main.java` limpo

### Como funciona
1.  Lê o salário mensal
2.  Calcula o valor da hora: `salário / 220`
3.  Calcula hora extra: `valorHora * (1 + %/100) * qtdHoras`
4.  Exibe resumo com salário base, extra e total

### Como rodar
```bash
git clone https://github.com/Andygarcia2026/calculadora-horas-extras.git
javac Main.java CalculadoraHoraExtra.java
java Main
```

Exemplo de uso

=== CALCULADORA DE HORAS EXTRAS - V1.4 ===
Base CLT: 220h mensais

Digite seu salário mensal (ex: 3500 ou 3.500 ou 2500,50): 3.500,50
Seu valor por hora é: R$ 15,91

Quantas horas extras fez: 10
Porcentagem do adicional (50, 70, 100): 50

Salário base: R$ 3500,50
Horas extras (50%): R$ 238,71
TOTAL: R$ 3739,21
```

### Próximos passos
- [ ] Criar testes unitários com JUnit
- [ ] Adicionar cálculo de DSR sobre hora extra
- [ ] Criar interface gráfica com JavaFX
