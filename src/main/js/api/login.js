const request = require('superagent-promise')(require('superagent'), require('promise'));

export const registerUser = (data) => {
    return request.post('/register')
        .send(data)
        .end()
}

export const login = (data) => {
    return request.post('/login')
        .set('Content-Type', 'application/json')
        .send(data)
        .end()
}

export const logout = () => {
    return request.post('/logout')
        .set('Content-Type', 'application/json')
        .end()
}

export const confirmEmail = (token) => {
    return request.post(`/confirm/${token}`)
        .send({token: token})
        .end()
}

export const getUser = () => {
    return request.get('api/user/get')
        .end()
}