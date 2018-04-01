const request = require('superagent-promise')(require('superagent'), require('promise'));

export const getAllProducts = () => {
    return request.get('/api/products/get')
        .end()
}