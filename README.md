# Projeto para avaliação da empresa GFT

Script de construção e realização dos testes
 - mvn clean package install
 
Script para execucao da aplicacao (Tem que estar no diretório da aplicação)
 - java -jar avaliacaogft-0.0.1-SNAPSHOT-jar-with-dependencies.jar
 
 
 
 -------------------------------------------
 
# Instruções
Por favor, leia atentamente as informações abaixo. Siga as instruções para concluir seu código usando o idioma de sua escolha. Depois de concluir este estágio, você deve publicar seu código no GitHub e enviar o link para o GFT Recruiter.

#O estágio do desenvolvedor é avaliado em:
1. Projeto Orientado a Objetos
2. Legibilidade
3. Manutenção
4. Testabilidade

# Requerimentos técnicos:
1. Crie esta solução como um aplicativo de console
2. A solução deve ter testes unitários
3. A solução deve ter um script de construção que possa compilar e testar a solução a partir do
linha de comando
4. Coloque sua solução em um repositório GitHub e nos envie um link quando terminar

# Regras:
1. Você deve inserir a hora do dia como "manhã" ou "noite"
2. Você deve inserir uma lista delimitada por vírgulas de tipos de pratos com pelo menos uma seleção
3. A saída deve imprimir comida na seguinte ordem: entrada, Acompanhamento, bebida, sobremesa
4. Não há sobremesa para as refeições da manhã
5. A entrada não diferencia maiúsculas de minúsculas
6. Se uma seleção inválida for encontrada, exiba as seleções válidas até o erro e, em seguida,
erro de impressão
7. De manhã, você pode pedir várias xícaras de café
8. À noite, você pode ter várias ordens de batatas
9. Exceto pelas regras acima, você só pode pedir 1 de cada tipo de prato



# Pratos para cada hora do dia


Tipo Prato        | Manha         | Noite  |
--------------------------------------------

1 Entrada         | Ovos          | Bife   |

2 Acompanhamento  | Torrada       | Batata |

3 Bebida          | Café          | Vinho  |

4 Sobremesa       | Indisponível  | Bolo   |


# Exemplos de entradas e saidas:

Input: manha, 1, 2, 3, 4
Output: ovos, torrada, cafe, erro de impressao

Input: manha, 1, 2, 3
Output: ovos, torrada, cafe

Input: manha, 2, 1, 3
Output: ovos, torrada, cafe

Input: manha, 1, 2, 3, 3, 3
Output: ovos, torrada, cafe(x3)

Input: noite, 1, 2, 3, 4
Output: bife, batata, vinho, bolo

Input: noite, 1, 2, 2, 4
Output bife, batata(x2), bolo
