describe('Payment API', () => {

  it('POST deve criar pagamento', () => {
    cy.request({
      method: 'POST',
      url: 'http://localhost:8082/payments',
      body: {
        amount: 500,
        description: 'teste gitbash'
      }
    }).then((res) => {
      expect(res.status).to.eq(200)
      expect(res.body).to.have.property('id')
    })
  })

  it('GET deve listar pagamentos', () => {
    cy.request('http://localhost:8082/payments')
      .then((res) => {
        expect(res.status).to.eq(200)
        expect(res.body).to.be.an('array')
      })
  })

})