const STORAGE_KEY = 'token';
export default {
    get() {
        return JSON.parse(window.localStorage.getItem(STORAGE_KEY) || '[]')
    },
    save(items) {
        window.localStorage.setItem(STORAGE_KEY, JSON.stringify(items))
    }
}