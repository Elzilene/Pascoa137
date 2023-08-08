##language:pt
#  Funcionalidade: Selecionar Passagem
#    Cen�rio: Selecionar Passagem com Sucesso
#      Dado que acesso o site Blazedemo
#      Quando Seleciono a origem como "S�o Paolo" e destino "Berlin"
#      E clico em Procurar Voo
#      Ent�o exibe a frase indicando voo entre "S�o Paolo" e "Berlin"

Feature:Selecionar Passagem
  Scenario: Selecionar Passagem com Sucesso
    Given que acesso o site Blazedemo
    When seleciono a origem como "S�o Paolo" e destino "Berlin"
    And clico em Procurar Voo
    Then exibe a frase indicando voo entre "S�o Paolo" e "Berlin"
