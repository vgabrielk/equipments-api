# Projeto Spring treino


## O Desafio

Você é um desenvolvedor backend contratado por uma empresa de tecnologia que fornece soluções para monitoramento de equipamentos utilizados em operações florestais. A empresa precisa de uma aplicação capaz de gerenciar e expor informações sobre os equipamentos, incluindo suas posições e estados ao longo do tempo.

Os equipamentos podem estar em diferentes estados, como Operando, Parado ou em Manutenção. Essas informações são fundamentais para análises de produtividade, custos operacionais e manutenção preditiva. A posição dos equipamentos é coletada via GPS e armazenada periodicamente, permitindo um rastreamento preciso da operação.
Seu objetivo é, de posse desses dados, desenvolver uma aplicação backend que exponha esses dados através de uma API.



## Dados

![Diagrama](https://cdn.discordapp.com/attachments/954772135518294048/1338294237258584160/diagram.png?ex=67aa8f22&is=67a93da2&hm=ee68a309c6a61d0fe2c37bb64632f188ef1e1b3083bd1928cfc2a52bba63897a&)

### equipment
Contém todos os equipamentos da aplicação.

* **id**: Identificador único do equipamento.
* **equipment_model_id**: Chave estrangeira, utilizada para referenciar de qual modelo é esse equipamento.
* **name**: Nome do equipamento.

### equipment_state
Contém todos os estados dos equipamentos.

* **id**: Identificador único do estado de equipamento
* **name**: Nome do estado.
* **color**: Cor utilizada para representar o estado.

### equipment_type (tipo, mesma coisa que modelo)
Contém todos os modelos de equipamentos.

* **id**: Identificador único do tipo de equipamento.
* **name**: Nome do tipo de equipamento.

### equipment_model_state_hourly_earnings
Informação de qual é o valor por hora do modelo de equipamento em cada um dos estados.

* **equipment_model_id**: Chave estrangeira, utilizada para referenciar de qual modelo é esse valor.
* **equipment_state_id**: Chave estrangeira, utilizada para referenciar de qual valor é esse estado.
* **value**: Valor gerado por hora nesse estado.

### equipment_state_history
O histórico de estados por equipamento.

* **equipment_id**: Chave estrangeira, utilizada para referenciar de qual equipamento é esse estado.
* **date**: Data em que o equipamento declarou estar nesse estado.
* **equipment_state_id**: Chave estrangeira, utilizada para referenciar qual é o estado que o equipamento estava nesse momento.

### equipment_position_history
O histórico de posições dos equipamentos.

* **equipment_id**: Chave estrangeira, utilizada para referenciar de qual equipamento é essa posição.
* **date**: Data em que a posição foi registrada.
* **lat**: Latitude em WGS84.
* **lon**: Longitude em WGS84.
