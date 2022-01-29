# Gestao Clientes API

* Um schema de banco de dados postgres esta disposto [aqui](https://github.com/Brisanet/Recrutamento).

    
# Cadastros

Será dispostas rotas que tornem possível: cadastrar, alterar, recuperar e desativar (soft delete) clientes e endereços. Ao efetuar as operações exigidas, deve- se atentar aos seguintes detalhes:

* Não deve ser possível cadastrar clientes ou endereços com dados idênticos à um já existente (registro duplicado)

* Caso haja uma tentativa de registro duplicado em um cliente ou endereço desativado, o sistema deve realizar a reativação (definindo a valor do campo "data_remoção" como nulo no banco de dados)

* No momento de recuperação dos dados, deve ser possível filtrar os dados retornados através dos campos especificados acima.

## Clientes
### cadastrar

    POST /api/v1/clientes
    Content-Type: application/json
    {
    "nome" : "Cliente da Silva",
    "tipo" : "jurídico"
    }
Seguem os dados requeridos para o cadastro de um **cliente**:
Dado | Tipo  | Obrigatório
-----|-------|------------
Nome | Texto | Sim    
Tipo | Texto | Sim    

Os tipos de clientes disponíveis são: **jurídico**, **físico** e **especial**. Os status code esperados são: 201 (sucesso), 400 (erro)

### Listar
    GET /api/v1/clientes

Filtros que devem estar dispostos através de **query parameters** da requisição:

Filtro | Descrição  
-------|-----------
Nome   | Nome parcial ou completo do cliente que se deseja filtrar    
Tipo   | Tipo de clientes que devem ser filtrados  

Resposta:

Deve conter um array de objetos nomeado **dados** com os dados dos clientes.

    {
        "dados": [
            {
                "nome" : "Cliente da Silva",
                "tipo" : "jurídico"
            }
        ]
    }

Os status code esperados são: 200 (sucesso), 400 (erro)

### Alterar

    PUT /api/v1/cliente/{uuid}

    Content-Type: application/json

    {
        "nome" : "Cliente da Costa",
        "tipo" : "físico"
    }

O parâmetro apresentado no Path é o uuid do cliente que se deseja alterar e é obrigatório.

Dado | Tipo  | Obrigatório
-----|-------|------------
Nome | Texto | Não    
Tipo | Enum  | Não  

Os status code esperados são: 204 (sucesso), 400 (erro)

### Buscar

    GET /api/v1/cliente/{uuid}

O parâmetro apresentado no Path é o uuid do cliente que se deseja recuperar os dados e é obrigatório.

Resposta:

Deve conter um único objeto com os dados dos cliente em questão.

    {
        "nome" : "Cliente da Silva",
        "tipo" : "jurídico"
    }

Os status code esperados são: 200 (sucesso), 400 (erro)

### Deletar

    DELETE /api/v1/cliente/{uuid}

O parâmetro apresentado no Path é o uuid do cliente que se deseja deletar e é obrigatório.

Os status code esperados são: 204 (sucesso), 400 (erro)

## Endereços

### Cadastrar

    POST /api/v1/enderecos

    Content-Type: application/json

    {
        "logradouro" : "Rua do Cliente",
        "bairro" : "Crato",
        "numero": 100
    }

Seguem os dados requeridos para o cadastro de um endereço:

Dado       | Tipo    | Obrigatório
-----------|---------|------------
Logradouro | Texto   | Sim    
Bairro     | Enum    | Sim  
Numero     | Númerico| Sim

Os status code esperados são: 201 (sucesso), 400 (erro)

### Listar

    GET /api/v1/enderecos

Filtros que devem estar dispostos através de query parameters da requisição:

Filtro     | Descrição  
-----------|-----------
Logradouro | Nome parcial ou completo do logradouro que se deseja filtrar      
Bairro     | Nome parcial ou completo do bairro que se deseja filtrar     
Numero     | Numero do endereço que se deseja filtrar

Resposta:

Deve conter um array de objetos nomeado dados com os dados dos endereços.

    {
        "dados": [
            {
                "logradouro" : "Rua do Cliente",
                "bairro" : "Crato",
                "numero": 100
            }
        ]
    }

Os status code esperados são: 200 (sucesso), 400 (erro)

### Alterar

    PUT /api/v1/endereco/{uuid}

    Content-Type: application/json

    {
        "logradouro" : "Avenida do Cliente",
        "bairro" : "Barbalha",
        "numero": 200
    }

O parâmetro apresentado no Path é o uuid do endereço que se deseja alterar e é obrigatório.

Dado       | Tipo    | Obrigatório
-----------|---------|------------
Logradouro | Texto   | Não    
Bairro     | Enum    | Não  
Numero     | Númerico| Não

Os status code esperados são: 204 (sucesso), 400 (erro)

### Buscar

    GET /api/v1/endereco/{uuid}

O parâmetro apresentado no Path é o uuid do endereço que se deseja recuperar os dados e é obrigatório.

Resposta:

Deve conter um único objeto com os dados dos endereço em questão.

    {
        "logradouro" : "Avenida do Cliente",
        "bairro" : "Barbalha",
        "numero": 200
    }

Os status code esperados são: 200 (sucesso), 400 (erro)

### Deletar

    DELETE /api/v1/endereco/{uuid}
    
O parâmetro apresentado no Path é o uuid do endereço que se deseja deletar e é obrigatório.

Os status code esperados são: 204 (sucesso), 400 (erro)