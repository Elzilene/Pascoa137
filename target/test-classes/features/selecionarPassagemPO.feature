Feature:Selecionar Passagem
  Scenario: Selecionar Passagem com Sucesso
    Given que acesso o site Blazedemo
    When seleciono a origem como "S�o Paolo" e destino "Berlin"
    And clico em Procurar Voo
    Then exibe a frase indicando voo entre "S�o Paolo" e "Berlin"
