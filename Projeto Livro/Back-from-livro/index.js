const express = require('express')
const cors = require('cors')
const app = express()
const axios = require('axios')
const port = process.env.PORT
app.use(express.json())
app.use(cors())

app.get('/consultas', async(req, res) => {
    if(req.query.tipo == 'livros'){
        const result = await axios.get('http://localhost:8080/livros')
        return res.send(result.data)
    }
    if(req.query.tipo == 'pessoas'){
        return res.send({message: "consulta pessoas"})
    }

    // res.send({message:"informe qual consulta deseja fazer"})
})

app.listen(port, () => {
    console.log(`executando em http://localhost:${port}`)
})